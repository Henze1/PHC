package com.main.phc.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.main.phc.inside.Member

class MemberViewModel: ViewModel() {
    companion object {
        var member by mutableStateOf<Member?>(null)
    }
}