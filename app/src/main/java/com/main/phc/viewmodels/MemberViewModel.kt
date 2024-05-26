package com.main.phc.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.lifecycle.ViewModel
import com.main.phc.inside.Member

class MemberViewModel: ViewModel() {
    var member by mutableStateOf<Member?>(null)
    companion object {
        val memberList = SnapshotStateList<Member>()
    }
}