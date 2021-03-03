import kotlinx.serialization.Serializable

/*
Copyright (c) 2021 Kotlin Data Classes Generated from JSON powered by http://www.json2kotlin.com

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.

For support, please feel free to contact me at https://www.linkedin.com/in/syedabsar */

@Serializable
data class Fields (

	val blind : Int? = null,
	val pmr : Int? = null,
	val date_end : String? = null,
	val deaf : Int? = null,
	val updated_at : String? = null,
	val access_type : String? = null,
	val occurrences : String? = null,
	val contact_name : String? = null,
	val address_street : String? = null,
	val id : Int? = null,
	val lat_lon : List<Double>,
	val category : String? = null,
	val title : String? = null,
	val cover_alt : String? = null,
	val date_start : String? = null,
	val contact_url : String? = null,
	val address_name : String? = null,
	val description : String? = null,
	val tags : String? = null,
	val access_mail : String? = null,
	val lead_text : String? = null,
	val cover_url : String? = null,
	val cover_credit : String? = null,
	val address_city : String? = null,
	val programs : String? = null,
	val price_type : String? = null,
	val cover : Cover,
	val url : String? = null,
	val date_description : String? = null,
	val address_zipcode : Int? = null,
	val transport : String? = null
)