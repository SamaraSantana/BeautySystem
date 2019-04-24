package br.com.beautysystem

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.widget.Toolbar
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_tela_inicial.*
import kotlinx.android.synthetic.main.toolbar.*

class LocalizacaoActivity : DebugActivity(), NavigationView.OnNavigationItemSelectedListener{
    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId){

            R.id.nav_cliente -> {
                val intent = Intent(this, ClienteActivity::class.java)
                startActivityForResult(intent,10)
            }
            R.id.nav_historico-> {
                val intent = Intent(this,HistoricoActivity::class.java)
                startActivityForResult(intent,10)
            }
            R.id.nav_localizacao-> {
                val intent = Intent(this, LocalizacaoActivity::class.java)
                startActivityForResult(intent,10)
            }
            R.id.nav_agenda-> {
                val intent = Intent(this, AgendaActivity::class.java)
                startActivityForResult(intent,10)
            }
            R.id.nav_sair -> {
                var intent = Intent(this,MainActivity::class.java)
                Toast.makeText(this, "Sair", Toast.LENGTH_SHORT).show()
                startActivityForResult(intent, 10)
                finish()
            }
        }
        layoutMenuLateral.closeDrawer(GravityCompat.START)
        return true
    }

    fun configuraMenuLateral(){
        val toolbar = toolbar
        val layoutMenuLateral = layoutMenuLateral

        var toggle = ActionBarDrawerToggle(this,layoutMenuLateral,toolbar,R.string.drawer_open,R.string.drawer_close)

        layoutMenuLateral.addDrawerListener(toggle)
        toggle.syncState()
        val navigationView =  menu_tela_inicial
        navigationView.setNavigationItemSelectedListener(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_localizacao)
        val progressBar: ProgressBar = this.progressBar1

        // colocar toolbar
        var toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)


        // alterar título da ActionBar
        supportActionBar?.title = "Localizacao"

        // up navigation
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        configuraMenuLateral()

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        //pega o id que definimos
        val id = item?.itemId
        if (id == R.id.action_buscar) {
            Toast.makeText(this, "Clicou buscar", Toast.LENGTH_SHORT).show()
        } else if (id == R.id.action_atualizar) {
            Thread(Runnable {
                // dummy thread mimicking some operation whose progress cannot be tracked

                // display the indefinite progressbar
                this@LocalizacaoActivity.runOnUiThread(java.lang.Runnable {
                    val progressBar : ProgressBar = this.progressBar1
                    progressBar.visibility = View.VISIBLE
                })

                // performing some dummy time taking operation
                try {
                    var i = 0;
                    while (i < Int.MAX_VALUE) {
                        i++
                    }
                } catch (e: InterruptedException) {
                    e.printStackTrace()
                }

                // when the task is completed, make progressBar gone
                this@LocalizacaoActivity.runOnUiThread(java.lang.Runnable {
                    val progressBar : ProgressBar = this.progressBar1
                    progressBar.visibility = View.GONE
                })
            }).start()
            //Toast.makeText(this, "Clicou atualizar", Toast.LENGTH_SHORT).show()
        }else if (id == R.id.action_config) {
            val intent = Intent(this,ConfiguracaoActivity::class.java)
            startActivityForResult(intent, 10)
        }
        else if (id == android.R.id.home){
            Toast.makeText(this, "Clicou voltar", Toast.LENGTH_SHORT).show()
            finish()
        }
        return super.onOptionsItemSelected(item)
    }
}