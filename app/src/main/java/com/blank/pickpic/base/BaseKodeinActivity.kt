package com.blank.pickpic.base

import androidx.appcompat.app.AppCompatActivity
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.kodein


open class BaseKodeinActivity : AppCompatActivity(), KodeinAware {
    override val kodein: Kodein by kodein()
}