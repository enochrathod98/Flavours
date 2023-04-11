package com.example.flavorsdemo.feature.userlist.data.model

enum class Status(val intValue: Int) {
    PENDING(0),
    APPROVED(1),
    REJECTED(2);

    companion object {
        fun fromApiValue(intValue: Int) : Status?  {
            return Status.values().firstOrNull {
                it.intValue == intValue
            }
        }
    }
}

/*
API tells:

status : 0 / 1 / 2

0 - PENDING
1 - APPROVED
2 - REJECTED

 */
