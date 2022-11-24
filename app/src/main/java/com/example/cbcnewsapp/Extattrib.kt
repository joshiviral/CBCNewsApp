package com.example.cbcnewsapp

data class Extattrib(
    val captionUrl: String,
    val displaycomments: Boolean,
    val guid: String,
    val hasaudio: Boolean,
    val hasgallery: Boolean,
    val hasvideo: Boolean,
    val kicklink: Kicklink,
    val liveondemand: String,
    val mediaid: String,
    val mediatype: String,
    val olympictags: Any,
    val photocount: Int,
    val releaseid: String,
    val runtime: Double,
    val syndicate: String,
    val urlslug: String,
    val vfsection: String,
    val yospaceid: String
)