package pers.jay.lib_global.model.bean

import android.os.Parcel
import android.os.Parcelable

/**
 * admin : false
 * chapterTops : []
 * collectIds : [7484,2696,7654,5573,7958,8252,8227,8080,3365,2439,1467,3596,2897,979,8247,8438,8694]
 * email :
 * icon :
 * id : 12331
 * nickname : RookieJay
 * password :
 * token :
 * type : 0
 * username : RookieJay
 */
data class User(
    var isAdmin: Boolean = true,
    var email: String? = "",
    var icon: String? = "",
    var id: Int = 0,
    var nickname: String? = "",
    var password: String? = "",
    var token: String? = "",
    var type: Int,
    var username: String? = "",
    var chapterTops: List<*>?,
    var collectIds: List<*>?
) : Parcelable {
    override fun toString(): String {
        return "User(isAdmin=$isAdmin, email='$email', icon='$icon', id=$id, nickname='$nickname', password='$password', token='$token', type=$type, username='$username', chapterTops=$chapterTops, collectIds=$collectIds)"
    }

    constructor(source: Parcel) : this(
        1 == source.readInt(),
        source.readString(),
        source.readString(),
        source.readInt(),
        source.readString(),
        source.readString(),
        source.readString(),
        source.readInt(),
        source.readString(),
        ArrayList<Any?>().apply { source.readList(this, Any::class.java.classLoader) },
        ArrayList<Any?>().apply { source.readList(this, Any::class.java.classLoader) }
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeInt((if (isAdmin) 1 else 0))
        writeString(email)
        writeString(icon)
        writeInt(id)
        writeString(nickname)
        writeString(password)
        writeString(token)
        writeInt(type)
        writeString(username)
        writeList(chapterTops)
        writeList(collectIds)
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<User> = object : Parcelable.Creator<User> {
            override fun createFromParcel(source: Parcel): User = User(source)
            override fun newArray(size: Int): Array<User?> = arrayOfNulls(size)
        }
    }
}