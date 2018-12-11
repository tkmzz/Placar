package br.com.luiz.placar.ui.placaraac

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import br.com.luiz.placar.R
import kotlinx.android.synthetic.main.activity_placar_aac.*

class PlacarAACActivity : AppCompatActivity() {

    lateinit var placarAACViewModel: PlacarAACViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_placar_aac)

        placarAACViewModel = ViewModelProviders
                .of(this)
                .get(PlacarAACViewModel::class.java)

        registraObservers()

        //Add pts time A
        bt3PontosTimeA.setOnClickListener {
            placarAACViewModel.adicionaPontoTimeA(3)
        }
        bt2PontosTimeA.setOnClickListener {
            placarAACViewModel.adicionaPontoTimeA(2)
        }
        bt1PontoTimeA.setOnClickListener {
            placarAACViewModel.adicionaPontoTimeA(1)
        }

        //Add pts time B
        bt3PontosTimeB.setOnClickListener {
            placarAACViewModel.adicionaPontoTimeB(3)
        }
        bt2PontosTimeB.setOnClickListener {
            placarAACViewModel.adicionaPontoTimeB(2)
        }
        bt1PontoTimeB.setOnClickListener {
            placarAACViewModel.adicionaPontoTimeB(1)
        }

        //Reiniciar pts
        btReiniciar.setOnClickListener {
            placarAACViewModel.reiniciarJogo()
        }
    }

    private fun registraObservers() {
        placarAACViewModel.placarA.observe(this, Observer{
            tvPlacarTimeA.text = it.toString()
        })

        placarAACViewModel.placarB.observe(this, Observer {
            tvPlacarTimeB.text = it.toString()
        })
    }
}
