package com.example.criminalintent

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_crime)

        val currentFragment = supportFragmentManager.findFragmentById(R.id.fragment_container)
        if (currentFragment == null) {
            val fragment = CrimeFragment()
            supportFragmentManager.beginTransaction().add(R.id.fragment_container, fragment).commit()
            /* Транзакции фрагментов исп. для добавления, удаления, замены, присоединения, отсоединения
            * фрагмента в списке фрагментов.
            * Данный код означает: создать новую транзакцию фрагмента, добавить в нее новый фрагмент и закрепить */
        }
    }
}