package e.rick.social_network.Presentation.HomeActivity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.Toolbar
import e.rick.social_network.Model.PostObj
import e.rick.social_network.R
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.main_toolbar.*

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        setSupportActionBar(toolbar)

        val postObj = PostObj("xaxa", "to sarrando na xaxa", null)

        var listItem = ArrayList<PostObj>()
        listItem.add(postObj)

        recyclerView.adapter = PostAdapter(listItem, this)
        recyclerView.layoutManager = LinearLayoutManager(this) as RecyclerView.LayoutManager?
    }
}