package com.example.student

import android.os.Parcel
import android.os.Parcelable

data class Student(
    var name: String?, var lastName: String?, var age: Int, var isDeveloper: Boolean = true

) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readInt(),
        parcel.readByte() != 0.toByte()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeString(lastName)
        parcel.writeInt(age)
        parcel.writeByte(if (isDeveloper) 1 else 0)
    }

    override fun describeContents(): Int {
        return 0
    }


    companion object CREATOR : Parcelable.Creator<Student> {
        //esto creara el objeto desde el parcel llamando al constructor sec
        override fun createFromParcel(parcel: Parcel): Student {
            return Student(parcel)
        }

        // esto serializa array de la clase Student
        override fun newArray(size: Int): Array<Student?> {
            return arrayOfNulls(size)
        }
    }
}