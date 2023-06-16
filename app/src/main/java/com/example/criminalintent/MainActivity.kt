package com.example.criminalintent

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import java.util.UUID

private const val TAG = "MainActivity"
class MainActivity : AppCompatActivity(), CrimeListFragment.Callbacks {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_crime)

        val currentFragment = supportFragmentManager.findFragmentById(R.id.fragment_container)
        if (currentFragment == null) {
            val fragment = CrimeListFragment.newInstance()
            supportFragmentManager.beginTransaction().add(R.id.fragment_container, fragment).commit()
            /* Транзакции фрагментов исп. для добавления, удаления, замены, присоединения, отсоединения
            * фрагмента в списке фрагментов.
            * Данный код означает: создать новую транзакцию фрагмента, добавить в нее новый фрагмент и закрепить */
        }
    }

    override fun onCrimeSelected(crimeId: UUID) {
        val fragment = CrimeFragment.newInstance(crimeId)
        supportFragmentManager.beginTransaction()
            .addToBackStack(null) // возвращает обратно при нажатии "Назад"
            .replace(R.id.fragment_container, fragment).commit()
    }

}