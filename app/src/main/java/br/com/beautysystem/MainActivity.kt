package br.com.beautysystem

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import br.com.beautysystem.R

import kotlinx.android.synthetic.main.login.*

class MainActivity : DebugActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // setContentView(R.layout.activity_main)
        setContentView(R.layout.login)
        //Elemento da imagem


        // user é o nome da minha imagem
        img.setImageResource(R.drawable.logo)

        // var botao = botao
        botaoLogin.setOnClickListener { clicou() }

        var lembrar = Prefs.getBoolean("lembrar")
        if (lembrar) {
            var lembrarNome = Prefs.getString("lembrarNome")
            var lembrarSenha = Prefs.getString("lembrarSenha")
            text_usuario.setText(lembrarNome)
            text_senha.setText(lembrarSenha)
            checkLogin.isChecked = lembrar
        }

    }

        fun clicou() {
            val campoUsuario = findViewById<EditText>(R.id.text_usuario)
            val campoSenha = findViewById<EditText>(R.id.text_senha)
            var nomeUsuario = text_usuario.text.toString()
            var senha = text_senha.text.toString()

            if (nomeUsuario == "aluno" && senha =="impacta") {

                //Toast.makeText(this, "Clicou no botão : ${nomeUsuario}", Toast.LENGTH_SHORT).show()
                var intent = Intent(this, TelaInicialActivity::class.java)
                // passando um parametro para outra tela
                var parameter = Bundle()
                parameter.putString("nome", nomeUsuario)
                parameter.putString("senha", senha)
                parameter.putInt("numero", 10)


                intent.putExtras(parameter)
                startActivityForResult(intent, 10)

            } else {
                Toast.makeText(this, "Usuario ou senha errada", Toast.LENGTH_SHORT).show()
        }

            //IMPLEMENTAÇÃO NOVA
            Prefs.setBoolean("lembrar", checkLogin.isChecked)

            if (checkLogin.isChecked) {
                Prefs.setString("lembrarNome", nomeUsuario)
                Prefs.setString("lembrarSenha",senha)
            } else {
                Prefs.setString("lembrarNome", "")
                Prefs.setString("lembrarSenha", "")
            }

    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
      Toast.makeText(this,data?.getStringExtra("resultado"),Toast.LENGTH_SHORT).show()

    }

    }

