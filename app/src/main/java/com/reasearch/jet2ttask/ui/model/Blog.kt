
data class Blog (

	val id : Int,
	val createdAt : String,
	val content : String,
	val comments : Int?,
	val likes : Int?,
	var media : List<Media>?,
	var user : List<User>?
)