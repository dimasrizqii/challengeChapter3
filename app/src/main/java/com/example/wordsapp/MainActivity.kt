package com.example.wordsapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commit
import com.example.wordsapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() , OnDataPass {
    private var _binding : ActivityMainBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val letterFragment = LetterListFragment()
        val fragmentManager = supportFragmentManager

        fragmentManager.commit {
            add(R.id.activity_host, letterFragment)
        }
    }

    override fun onDataPass(letter: String) {
        val wordFragment = WordListFragment()

        val bundle = Bundle()
        bundle.putString("letter", letter)

        wordFragment.arguments = bundle
        val fragmentManager = supportFragmentManager
        fragmentManager.beginTransaction()
            .addToBackStack(null)
            .replace(R.id.activity_host, wordFragment)
            .commit()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}
