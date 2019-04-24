package br.com.beautysystem


import android.content.Intent
import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.RecyclerView.LayoutManager
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.*
import kotlinx.android.synthetic.main.activity_tela_inicial.*
import android.support.v7.widget.Toolbar
import android.widget.Toast
import br.com.beautysystem.R.id.action_buscar
import kotlinx.android.synthetic.main.toolbar.*
import android.support.v7.widget.SearchView

class TelaInicialActivity : DebugActivity(), NavigationView.OnNavigationItemSelectedListener{
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
        setContentView(R.layout.activity_tela_inicial)
        val progressBar: ProgressBar = this.progressBar1


        val args = intent.extras
        val nome = args.getString("nome")

        // Toast.makeText(this, "Parametro enviado: $nome", Toast.LENGTH_SHORT).show()


        Toast.makeText(this, "Bem Vindo(a) : $nome", Toast.LENGTH_SHORT).show()




        // colocar toolbar
        var toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)


        // alterar título da ActionBar
        supportActionBar?.title = "Home"

        // up navigation
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

       novidades.setOnClickListener{
            val titulo = "Novidades"
            var intent = Intent(this, MenuActivity::class.java)
            var arg = Bundle()
            arg.putString("title", titulo)
            intent.putExtras(arg)
            startActivity(intent)
        }

        meus_dados.setOnClickListener{
            val titulo = "Meus Dados"
            var intent = Intent(this, MenuActivity::class.java)
            var arg = Bundle()
            arg.putString("title", titulo)
            intent.putExtras(arg)
            startActivity(intent)
        }

       tratamentos.setOnClickListener{
            val titulo = "Tratamentos"
            var intent = Intent(this, MenuActivity::class.java)
            var arg = Bundle()
            arg.putString("title", titulo)
            intent.putExtras(arg)
            startActivity(intent)
        }

        configuraMenuLateral()
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
        // vincular evento de buscar
        (menu?.findItem(R.id.action_buscar)?.actionView as SearchView).setOnQueryTextListener(object : SearchView.OnQueryTextListener {

            override fun onQueryTextChange(newText: String): Boolean {
                // ação enquanto está digitando
                return false
            }

            override fun onQueryTextSubmit(query: String): Boolean {

                var texto = action_buscar.toString()

                Toast.makeText(this@TelaInicialActivity, "${query}", Toast.LENGTH_LONG).show()
                return false
            }

        })
        return true
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
                this@TelaInicialActivity.runOnUiThread(java.lang.Runnable {
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
                this@TelaInicialActivity.runOnUiThread(java.lang.Runnable {
                    val progressBar : ProgressBar = this.progressBar1
                    progressBar.visibility = View.GONE
                })
            }).start()
        }else if (id == R.id.action_config) {
            val intent = Intent(this,ConfiguracaoActivity::class.java)
            startActivityForResult(intent, 10)
        } else if (id == android.R.id.home){
            Toast.makeText(this, "Clicou voltar", Toast.LENGTH_SHORT).show()
            finish()
        }
        return super.onOptionsItemSelected(item)
    }


}


