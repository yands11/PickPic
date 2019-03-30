package com.blank.pickpic.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Photo(
    @SerialName("id") val id: String,
    @SerialName("created_at") val createdAt: String,
    @SerialName("updated_at") val updatedAt: String,
    @SerialName("width") val width: Int,
    @SerialName("height") val height: Int,
    @SerialName("color") val color: String,
    @SerialName("likes") val likes: Long,
    @SerialName("liked_by_user") val likedByUser: Boolean,
    @SerialName("description") val description: String,
    @SerialName("user") val user: User,
    @SerialName("urls") val urls: Urls
)

@Serializable
data class User(
    @SerialName("id") val id: String,
    @SerialName("username") val userName: String,
    @SerialName("name") val name: String,
    @SerialName("portfolio_url") val portfolioUrl: String,
    @SerialName("bio") val bio: String,
    @SerialName("location") val location: String,
    @SerialName("total_likes") val totalLikes: Long,
    @SerialName("total_photos") val totalPhotos: Long,
    @SerialName("instagram_username") val instagramUsername: String,
    @SerialName("twitter_username") val twitterUsername: String,
    @SerialName("profile_image") val profileImage: ProfileImage,
    @SerialName("links") val links: Links
)

@Serializable
data class ProfileImage(
    val small: String,
    val medium: String,
    val large: String
)

@Serializable
data class Links(
    val self: String,
    val html: String,
    val photos: String,
    val likes: String,
    val portfolio: String
)

@Serializable
data class Urls(
    val raw: String,
    val full: String,
    val regular: String,
    val small: String,
    val thumb: String
)
