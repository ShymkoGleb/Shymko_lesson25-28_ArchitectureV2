package com.example.architecturev2.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.*
import com.example.architecturev2.models.PostsResponse


@Dao
interface PostsDao {
    @Query("SELECT * FROM post_response_table ORDER BY idKey DESC")
    suspend fun getAllPosts(): List<PostsResponse>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUserPost(post: PostsResponse)
}
