package com.base.mvvmbasekotlin.ui.list_account

import android.util.Log
import com.base.mvvmbasekotlin.base.BaseViewModel
import com.base.mvvmbasekotlin.base.entity.BaseListLoadMoreResponse
import com.base.mvvmbasekotlin.entity.User
import com.base.mvvmbasekotlin.extension.ListLoadMoreResponse
import com.base.mvvmbasekotlin.utils.ACTIVE
import com.google.firebase.firestore.DocumentReference
import com.google.firebase.firestore.FirebaseFirestore
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AccountViewModel @Inject constructor() : BaseViewModel() {

    var lastVisible : DocumentReference? = null

    var listAccounts = ListLoadMoreResponse<User>()

    var status : Int = ACTIVE

    fun getListAccount(isRefresh : Boolean = false){
        if(isRefresh){
            lastVisible = null
        }
        val db =  FirebaseFirestore.getInstance()
        val accountCollection = db.collection("account")

        val query = accountCollection
            .whereEqualTo("status",status)
            .limit(20)
        if(lastVisible != null){
            query.startAfter(lastVisible)
        }
        listAccounts.value = BaseListLoadMoreResponse<User>().loading()
        query.get()
            .addOnSuccessListener {
               val data =  it.documents.map { it.toObject(User::class.java)!! }
                listAccounts.value = BaseListLoadMoreResponse<User>().success(data,isRefresh,data.size < 20)
                Log.v("ahuhu","$data")
            }
            .addOnFailureListener {
                listAccounts.value = BaseListLoadMoreResponse<User>().error(it)
            }
    }
}