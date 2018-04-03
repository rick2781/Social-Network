package e.rick.social_network.Presentation.HomeActivity

import android.content.Context
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.Toolbar
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import e.rick.social_network.Model.PostObj
import e.rick.social_network.R
import io.github.yavski.fabspeeddial.SimpleMenuListenerAdapter
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.main_toolbar.*
import kotlinx.android.synthetic.main.menu_text.*
import kotlinx.android.synthetic.main.menu_text.view.*
import org.jetbrains.anko.alert

class HomeActivity : AppCompatActivity() {

    private var listItem = ArrayList<PostObj>()
    private var adapter = PostAdapter(listItem, this);

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        setSupportActionBar(toolbar)

        back_arrow.visibility = View.GONE

        val postObj = PostObj("rickpms", "\n" +
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce ultricies libero ut enim ornare tristique. Nulla viverra vehicula odio, a sollicitudin libero semper eu. Curabitur facilisis vehicula malesuada. Integer id venenatis ipsum. Aenean fermentum laoreet urna interdum tempus. Suspendisse nec nunc metus. Etiam venenatis pellentesque felis, at aliquet purus semper eget.", null)
        val postObj2 = PostObj("rickpms", "Donec arcu mauris, rutrum malesuada lorem sed, vehicula efficitur erat. Donec diam mi, tempus suscipit tempus in, eleifend maximus urna. Cras in lacus leo.", null)
        val postObj3 = PostObj("rickpms", "Nulla elementum commodo libero, sed lobortis nibh dignissim a.", null)
        val postObj4 = PostObj("rickpms", "Curabitur venenatis massa ante, eget ullamcorper ipsum luctus nec. In hac habitasse platea dictumst. Sed eget rutrum nisi, id malesuada nibh. Duis vitae urna sem.", null)

        listItem.add(postObj)
        listItem.add(postObj2)
        listItem.add(postObj3)
        listItem.add(postObj4)

        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this) as RecyclerView.LayoutManager?

        setupFabSelection()
    }

    private fun setupFabSelection() {

        home_fab.setMenuListener(object : SimpleMenuListenerAdapter() {

            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {

                when (menuItem.itemId) {

                    R.id.menu_text -> setupCustomDialog()

                }

                return false
            }
        })
    }

    fun setupCustomDialog(){

        val builder = AlertDialog.Builder(this)
        val inflater = getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val dialogLayout = inflater.inflate(R.layout.menu_text, rootLayout)
        builder.setView(dialogLayout)
        builder.setCancelable(false)
        builder.create().show()
        dialogLayout.post_button.setOnClickListener {

            listItem.add(PostObj("rickpms", post_text_area.text.toString(), null))
            adapter.notifyDataSetChanged()}
    }
}