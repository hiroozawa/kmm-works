package com.ninehundreds.kmmworks.network

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class WhizBang(

    @SerialName("id")
    var id: String? = null,

    @SerialName("code")
    var code: Int? = null,

    @SerialName("snap")
    var snap: String? = null,

    @SerialName("desc")
    var desc: String? = null

)