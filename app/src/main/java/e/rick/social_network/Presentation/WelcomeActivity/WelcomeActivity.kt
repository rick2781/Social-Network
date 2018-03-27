package e.rick.social_network

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import e.rick.advancedkotlin.Presentation.HomeActivity.WelcomeContract
import e.rick.advancedkotlin.Presentation.HomeActivity.WelcomePresenter
import e.rick.social_network.Presentation.HomeActivity.HomeActivity
import io.github.tonnyl.spark.Spark
import kotlinx.android.synthetic.main.activity_welcome.*

class WelcomeActivity : AppCompatActivity(), WelcomeContract.View {

    private lateinit var mSpark : Spark

    private val presenter : WelcomeContract.Presenter = WelcomePresenter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)

        setupBackgroundAnim()
        buttonListener()

        if (presenter.checkCurrentUser()) goToHomeActivity()
    }

    private fun setupBackgroundAnim() {

        mSpark = Spark.Builder()
                .setView(rootLayout)
                .setDuration(4000)
                .setAnimList(Spark.ANIM_RED_PURPLE)
                .build()
    }

    override fun onResume() {
        super.onResume()

        mSpark.startAnimation()
    }

    override fun onPause() {
        super.onPause()
        mSpark.stopAnimation()
    }

    private fun buttonListener() {

        login.setOnClickListener { presenter.loginWithEmail(email.text.toString(), password.text.toString()) }
    }

    override fun goToHomeActivity() {

        val intent = Intent(this, HomeActivity::class.java)
        startActivity(intent)
    }
}