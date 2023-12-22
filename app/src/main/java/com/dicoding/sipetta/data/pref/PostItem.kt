package com.dicoding.sipetta.data.pref

data class PostItem(
    val id: Int,
    val name: String,
    val description: String,
    val label: String,
    val textSim: String,
    val severity: String
)

object DummyDataProvider {
    val dummyData: List<PostItem> = listOf(
        PostItem(1, "sipetta", "tanaman saya muncul bercak karat terdapat juga titik kecil berwarna coklat lalu bercak tersebut berkembang menjadi lesi besar dan terlihat seperti serbuk karat. Tanaman saya yang lainnya juga mulai tertular sehingga menghambat pertumbuhan dan mengurangi kualitas hasil panen tanaman saya", "Karat", "Karat", "Parah"),
        PostItem(2, "aqyun", "Tanaman saya seperti muncul bercak karat dan saya baru menyadari hal tersebut. Apakah ini sudah separah itu ya?", "Karat", "Karat", "Sedang"),
        PostItem(3, "maulidin", "Sawinya kering", "Karat", "Karat", "Sedang"),
        PostItem(4, "beber", "Sawinya layu", "Karat", "Karat", "Sedang"),
        PostItem(5, "tata", "Sawinya hijau", "Karat", "Karat", "Sedang"),
        PostItem(6, "kyuna", "Sawinya kering", "Karat", "Karat", "Sedang"),
    )

    fun getPostById(postId: Int?): PostItem? {
        return dummyData.find { it.id == postId }
    }
}
