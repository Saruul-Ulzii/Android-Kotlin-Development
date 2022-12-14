package com.sw06d120.lesson4

import android.content.Intent
import android.os.Bundle
import android.view.Gravity
import android.widget.TableRow
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private var users: ArrayList<User> = ArrayList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        addDummyUsers()
        addDummyRows()

        btnAdd.setOnClickListener {
            addVersion()
        }
        btnLogin.setOnClickListener {
            val intent = Intent(this, WalmartLogin::class.java)
            startActivity(intent)
        }
    }

    fun addDummyUsers() {
        var user1: User = User("Johny", "English", "jenglish@gmail.com", "pass1234")
        var user2: User = User("David", "Albert", "dalbert@gmail.com", "pass3456")
        var user3: User = User("Marks", "Twin", "mtwin@gmail.com", "pass4672")
        var user4: User = User("Jack", "London", "jlondon@gmail.com", "pass7261")
        var user5: User = User("Thomas", "Edison", "tedison@gmail.com", "pass5714")

        users.add(user1)
        users.add(user2)
        users.add(user3)
        users.add(user4)
        users.add(user5)

        print("users: " + users)
    }

    fun addDummyRows() {
        addRow("Android1", "Code1")
        addRow("Android2", "Code2")
    }

    fun addRow(name: String, code: String) {
        // Create a new table row.
        val tableRow = TableRow(getApplicationContext()) // this
        // Set new table row layout parameters.
        val layoutParams = TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT)
        tableRow.setLayoutParams(layoutParams)
        // add values into row by calling addView()
        var lblName = TextView(this)
        lblName.setPadding(100, 0, 200, 0)
        lblName.gravity = Gravity.LEFT
        lblName.textSize = 20f
        lblName.text = name

        var lblCode = TextView(this)
        lblCode.setPadding(50, 0, 50 ,0)
        lblCode.gravity = Gravity.LEFT
        lblCode.textSize = 20f
        lblCode.text = code

        tableRow.addView(lblName)
        tableRow.addView(lblCode)
        // Finally add the created row row into layout
        tblView.addView(tableRow) // id from Layout_file
    }

    fun addVersion() {
        var androidVersion = txtAndroidName.text
        var androidCodeName = txtAndroidCodeName.text

        if (androidVersion.isNullOrEmpty()) {
            Toast.makeText(this, "Android version required!", Toast.LENGTH_SHORT).show()
            txtAndroidName.requestFocusFromTouch()
            return
        }

        if (androidCodeName.isNullOrEmpty()) {
            Toast.makeText(this, "Android code name required!", Toast.LENGTH_SHORT).show()
            txtAndroidCodeName.requestFocusFromTouch()
            return
        }

        addRow(androidVersion.toString(), androidCodeName.toString())
    }
}