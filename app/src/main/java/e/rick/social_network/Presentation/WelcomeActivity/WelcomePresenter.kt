package e.rick.advancedkotlin.Presentation.HomeActivity

import android.content.Intent
import android.util.Log
import android.util.Log.d
import com.google.firebase.auth.FirebaseAuth
import e.rick.social_network.Presentation.HomeActivity.HomeActivity
import e.rick.social_network.WelcomeActivity

class WelcomePresenter(view : WelcomeContract.View) : WelcomeContract.Presenter {

    private val mAuth = FirebaseAuth.getInstance()
    private val mView = view

    override fun loginWithEmail(email : String, password : String) {

        mAuth.signInWithEmailAndPassword(email, password).addOnSuccessListener {

            mView.goToHomeActivity()

        }.addOnFailureListener { d("WelcomePresenter", it.printStackTrace().toString()) }
    }

    override fun checkCurrentUser() : Boolean {

        mAuth.currentUser?.let { return true }

        return false
    }
}