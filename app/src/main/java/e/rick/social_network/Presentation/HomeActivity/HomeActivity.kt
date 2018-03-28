package e.rick.social_network.Presentation.HomeActivity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import e.rick.social_network.Model.PostObj
import e.rick.social_network.R
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val postObj = PostObj("xaxa", "to sarrando na xaxa", null)

        var listItem = ArrayList<PostObj>()
        listItem.add(postObj)

        recyclerView.adapter = PostAdapter(listItem)
        recyclerView.layoutManager = LinearLayoutManager(this) as RecyclerView.LayoutManager?
    }
}