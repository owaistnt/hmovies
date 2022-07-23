package com.artsman.hasqvarnamovies.data.movieslist.repository.network.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MoviesNetworkModel(
    val average_rating: Double,
    val backdrop_path: String,
    //val comments: Comments,
    val created_by: CreatedBy,
    val description: String,
    val id: Int,
    val iso_3166_1: String,
    val iso_639_1: String,
    val name: String,
    //val object_ids: ObjectIds,
    val page: Int,
    val poster_path: String,
    val `public`: Boolean,
    val results: List<Result>,
    val revenue: Long,
    val runtime: Int,
    val sort_by: String,
    val total_pages: Int,
    val total_results: Int
)

/*data class Comments(
    @SerialName("movie:100402")
    val movie_100402: String,
    @SerialName("movie:10138")
    val movie_10138: String,
    @SerialName("movie:10195")
    val movie_10195: String,
    @SerialName("movie:102382")
    val movie_102382: String,
    @SerialName("movie:102899")
    val movie_102899: String,
    @SerialName("movie:10658")
    val movie_10658: String,
    @SerialName("movie:118340")
    val movie_118340: String,
    @SerialName("movie:1250")
    val movie_1250: String,
    @SerialName("movie:127585")
    val movie_127585: String,
    @SerialName("movie:13056")
    val movie_13056: String,
    @SerialName("movie:13995")
    val movie_13995: String,
    @SerialName("movie:166424")
    val movie_166424: String,
    @SerialName("movie:1724")
    val movie_1724: String,
    @SerialName("movie:1726")
    val movie_1726: String,
    @SerialName("movie:1771")
    val movie_1771: String,
    @SerialName("movie:1927")
    val movie_1927: String,
    @SerialName("movie:1930")
    val movie_1930: String,
    @SerialName("movie:1979")
    val movie_1979: String,
    @SerialName("movie:2080")
    val movie_2080: String,
    @SerialName("movie:22059")
    val movie_22059: String,
    @SerialName("movie:24428")
    val movie_24428: String,
    @SerialName("movie:246655")
    val movie_246655: String,
    @SerialName("movie:263115")
    val movie_263115: String,
    @SerialName("movie:271110")
    val movie_271110: String,
    @SerialName("movie:283995")
    val movie_283995: String,
    @SerialName("movie:284052")
    val movie_284052: String,
    @SerialName("movie:284053")
    val movie_284053: String,
    @SerialName("movie:284054")
    val movie_284054: String,
    @SerialName("movie:293660")
    val movie_293660: String,
    @SerialName("movie:299534")
    val movie_299534: String,
    @SerialName("movie:299536")
    val movie_299536: String,
    @SerialName("movie:299537")
    val movie_299537: String,
    @SerialName("movie:315635")
    val movie_315635: String,
    @SerialName("movie:363088")
    val movie_363088: String,
    @SerialName("movie:36586")
    val movie_36586: String,
    @SerialName("movie:36647")
    val movie_36647: String,
    @SerialName("movie:36648")
    val movie_36648: String,
    @SerialName("movie:36657")
    val movie_36657: String,
    @SerialName("movie:36658")
    val movie_36658: String,
    @SerialName("movie:36668")
    val movie_36668: String,
    @SerialName("movie:429617")
    val movie_429617: String,
    @SerialName("movie:49538")
    val movie_49538: String,
    @SerialName("movie:497698")
    val movie_497698: String,
    @SerialName("movie:524434")
    val movie_524434: String,
    @SerialName("movie:557")
    val movie_557: String,
    @SerialName("movie:558")
    val movie_558: String,
    @SerialName("movie:559")
    val movie_559: String,
    @SerialName("movie:566525")
    val movie_566525: String,
    @SerialName("movie:634649")
    val movie_634649: String,
    @SerialName("movie:68721")
    val movie_68721: String,
    @SerialName("movie:71676")
    val movie_71676: String,
    @SerialName("movie:7220")
    val movie_7220: String,
    @SerialName("movie:76170")
    val movie_76170: String,
    @SerialName("movie:76338")
    val movie_76338: String,
    @SerialName("movie:8867")
    val movie_8867: String,
    @SerialName("movie:9480")
    val movie_9480: String,
    @SerialName("movie:9738")
    val movie_9738: String,
    @SerialName("movie:9947")
    val movie_9947: String,
    @SerialName("movie:9986")
    val movie_99861: String

)*/

@Serializable
data class CreatedBy(
    val gravatar_hash: String,
    val id: String,
    val name: String,
    val username: String
)

/*data class ObjectIds(
    val movie:100402: String,
    val movie:10138: String,
    val movie:10195: String,
    val movie:102382: String,
    val movie:102899: String,
    val movie:10658: String,
    val movie:118340: String,
    val movie:1250: String,
    val movie:127585: String,
    val movie:13056: String,
    val movie:13995: String,
    val movie:166424: String,
    val movie:1724: String,
    val movie:1726: String,
    val movie:1771: String,
    val movie:1927: String,
    val movie:1930: String,
    val movie:1979: String,
    val movie:2080: String,
    val movie:22059: String,
    val movie:24428: String,
    val movie:246655: String,
    val movie:263115: String,
    val movie:271110: String,
    val movie:283995: String,
    val movie:284052: String,
    val movie:284053: String,
    val movie:284054: String,
    val movie:293660: String,
    val movie:299534: String,
    val movie:299536: String,
    val movie:299537: String,
    val movie:315635: String,
    val movie:363088: String,
    val movie:36586: String,
    val movie:36647: String,
    val movie:36648: String,
    val movie:36657: String,
    val movie:36658: String,
    val movie:36668: String,
    val movie:429617: String,
    val movie:49538: String,
    val movie:497698: String,
    val movie:524434: String,
    val movie:557: String,
    val movie:558: String,
    val movie:559: String,
    val movie:566525: String,
    val movie:634649: String,
    val movie:68721: String,
    val movie:71676: String,
    val movie:7220: String,
    val movie:76170: String,
    val movie:76338: String,
    val movie:8867: String,
    val movie:9480: String,
    val movie:9738: String,
    val movie:9947: String,
    val movie:99861: String
)*/

@Serializable
data class Result(
    val adult: Boolean,
    val backdrop_path: String,
    val genre_ids: List<Int>,
    val id: Int,
    val media_type: String,
    val original_language: String,
    val original_title: String,
    val overview: String,
    val popularity: Double,
    val poster_path: String,
    val release_date: String,
    val title: String,
    val video: Boolean,
    val vote_average: Double,
    val vote_count: Int
)