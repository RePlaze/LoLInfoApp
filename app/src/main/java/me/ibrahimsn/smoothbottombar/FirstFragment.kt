package me.ibrahimsn.smoothbottombar

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.appcompat.widget.SearchView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class FirstFragment : Fragment() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: GridAdapter
    private lateinit var searchView: SearchView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_first, container, false)
        recyclerView = view.findViewById(R.id.recyclerView)
        searchView = view.findViewById(R.id.searchView)

        // Change the text color of the SearchView query text
        val searchText =
            searchView.findViewById<EditText>(androidx.appcompat.R.id.search_src_text)
        searchText.setTextColor(ContextCompat.getColor(requireContext(), R.color.white))

        val gridItems = mutableListOf(
            GridItem("Aatrox", R.drawable.aatrox),
            GridItem("Ahri", R.drawable.ahri),
            GridItem("Akali", R.drawable.akali),
            GridItem("Akshan", R.drawable.akshan),
            GridItem("Alistar", R.drawable.alistar),
            GridItem("Amumu", R.drawable.amumu),
            GridItem("Anivia", R.drawable.anivia),
            GridItem("Annie", R.drawable.annie),
            GridItem("Aphelios", R.drawable.aphelios),
            GridItem("Ashe", R.drawable.ashe),
            GridItem("AurelionSol", R.drawable.aurelionsol),
            GridItem("Azir", R.drawable.azir),
            GridItem("Bard", R.drawable.bard),
            GridItem("Blitzcrank", R.drawable.blitzcrank),
            GridItem("Brand", R.drawable.brand),
            GridItem("Briar", R.drawable.briar),
            GridItem("Braum", R.drawable.braum),
            GridItem("Caitlyn", R.drawable.caitlyn),
            GridItem("Camille", R.drawable.camille),
            GridItem("Cassiopeia", R.drawable.cassiopeia),
            GridItem("ChoGath", R.drawable.chogath),
            GridItem("Corki", R.drawable.corki),
            GridItem("Darius", R.drawable.darius),
            GridItem("Diana", R.drawable.diana),
            GridItem("DrMundo", R.drawable.drmundo),
            GridItem("Draven", R.drawable.draven),
            GridItem("Ekko", R.drawable.ekko),
            GridItem("Elise", R.drawable.elise),
            GridItem("Evelynn", R.drawable.evelynn),
            GridItem("Ezreal", R.drawable.ezreal),
            GridItem("Fiddlesticks", R.drawable.fiddlesticks),
            GridItem("Fiora", R.drawable.fiora),
            GridItem("Fizz", R.drawable.fizz),
            GridItem("Galio", R.drawable.galio),
            GridItem("Gangplank", R.drawable.gangplank),
            GridItem("Garen", R.drawable.garen),
            GridItem("Gnar", R.drawable.gnar),
            GridItem("Gragas", R.drawable.gragas),
            GridItem("Graves", R.drawable.graves),
            GridItem("Gwen", R.drawable.gwen),
            GridItem("Hecarim", R.drawable.hecarim),
            GridItem("Heimerdinger", R.drawable.heimerdinger),
            GridItem("Illaoi", R.drawable.illaoi),
            GridItem("Irelia", R.drawable.irelia),
            GridItem("Ivern", R.drawable.ivern),
            GridItem("Janna", R.drawable.janna),
            GridItem("JarvanIV", R.drawable.jarvaniv),
            GridItem("Jax", R.drawable.jax),
            GridItem("Jayce", R.drawable.jayce),
            GridItem("Jhin", R.drawable.jhin),
            GridItem("Jinx", R.drawable.jinx),
            GridItem("KaiSa", R.drawable.kaisa),
            GridItem("Kalista", R.drawable.kalista),
            GridItem("Karma", R.drawable.karma),
            GridItem("Karthus", R.drawable.karthus),
            GridItem("Kassadin", R.drawable.kassadin),
            GridItem("Ksante", R.drawable.ksante),
            GridItem("Katarina", R.drawable.katarina),
            GridItem("Kayle", R.drawable.kayle),
            GridItem("Kayn", R.drawable.kayn),
            GridItem("Kennen", R.drawable.kennen),
            GridItem("KhaZix", R.drawable.khazix),
            GridItem("Kindred", R.drawable.kindred),
            GridItem("Kled", R.drawable.kled),
            GridItem("KogMaw", R.drawable.kogmaw),
            GridItem("LeBlanc", R.drawable.leblanc),
            GridItem("LeeSin", R.drawable.leesin),
            GridItem("Leona", R.drawable.leona),
            GridItem("Lillia", R.drawable.lillia),
            GridItem("Lissandra", R.drawable.lissandra),
            GridItem("Lucian", R.drawable.lucian),
            GridItem("Lulu", R.drawable.lulu),
            GridItem("Lux", R.drawable.lux),
            GridItem("Malphite", R.drawable.malphite),
            GridItem("Malzahar", R.drawable.malzahar),
            GridItem("Maokai", R.drawable.maokai),
            GridItem("MasterYi", R.drawable.masteryi),
            GridItem("MissFortune", R.drawable.missfortune),
            GridItem("Mordekaiser", R.drawable.mordekaiser),
            GridItem("Milio", R.drawable.milio),
            GridItem("Morgana", R.drawable.morgana),
            GridItem("Nami", R.drawable.nami),
            GridItem("Nasus", R.drawable.nasus),
            GridItem("Nautilus", R.drawable.nautilus),
            GridItem("Neeko", R.drawable.neeko),
            GridItem("Nidalee", R.drawable.nidalee),
            GridItem("Nocturne", R.drawable.nocturne),
            GridItem("NunuWillump", R.drawable.nunuwillump),
            GridItem("Olaf", R.drawable.olaf),
            GridItem("Orianna", R.drawable.orianna),
            GridItem("Ornn", R.drawable.ornn),
            GridItem("Pantheon", R.drawable.pantheon),
            GridItem("Poppy", R.drawable.poppy),
            GridItem("Pyke", R.drawable.pyke),
            GridItem("Qiyana", R.drawable.qiyana),
            GridItem("Quinn", R.drawable.quinn),
            GridItem("Rakan", R.drawable.rakan),
            GridItem("Rammus", R.drawable.rammus),
            GridItem("RekSai", R.drawable.reksai),
            GridItem("Rell", R.drawable.rell),
            GridItem("Renekton", R.drawable.renekton),
            GridItem("Rengar", R.drawable.rengar),
            GridItem("Riven", R.drawable.riven),
            GridItem("Rumble", R.drawable.rumble),
            GridItem("Ryze", R.drawable.ryze),
            GridItem("Samira", R.drawable.samira),
            GridItem("Sejuani", R.drawable.sejuani),
            GridItem("Senna", R.drawable.senna),
            GridItem("Seraphine", R.drawable.seraphine),
            GridItem("Sett", R.drawable.sett),
            GridItem("Shaco", R.drawable.shaco),
            GridItem("Shen", R.drawable.shen),
            GridItem("Shyvana", R.drawable.shyvana),
            GridItem("Singed", R.drawable.singed),
            GridItem("Sion", R.drawable.sion),
            GridItem("Sivir", R.drawable.sivir),
            GridItem("Skarner", R.drawable.skarner),
            GridItem("Sona", R.drawable.sona),
            GridItem("Soraka", R.drawable.soraka),
            GridItem("Swain", R.drawable.swain),
            GridItem("Sylas", R.drawable.sylas),
            GridItem("Syndra", R.drawable.syndra),
            GridItem("TahmKench", R.drawable.tahmkench),
            GridItem("Taliyah", R.drawable.taliyah),
            GridItem("Talon", R.drawable.talon),
            GridItem("Taric", R.drawable.taric),
            GridItem("Teemo", R.drawable.teemo),
            GridItem("Thresh", R.drawable.thresh),
            GridItem("Tristana", R.drawable.tristana),
            GridItem("Trundle", R.drawable.trundle),
            GridItem("Tryndamere", R.drawable.tryndamere),
            GridItem("TwistedFate", R.drawable.twistedfate),
            GridItem("Twitch", R.drawable.twitch),
            GridItem("Udyr", R.drawable.udyr),
            GridItem("Urgot", R.drawable.urgot),
            GridItem("Varus", R.drawable.varus),
            GridItem("Vayne", R.drawable.vayne),
            GridItem("Veigar", R.drawable.veigar),
            GridItem("VelKoz", R.drawable.velkoz),
            GridItem("Vi", R.drawable.vi),
            GridItem("Viego", R.drawable.viego),
            GridItem("Viktor", R.drawable.viktor),
            GridItem("Vladimir", R.drawable.vladimir),
            GridItem("Volibear", R.drawable.volibear),
            GridItem("Warwick", R.drawable.warwick),
            GridItem("Wukong", R.drawable.wukong),
            GridItem("Xayah", R.drawable.xayah),
            GridItem("Xerath", R.drawable.xerath),
            GridItem("XinZhao", R.drawable.xinzhao),
            GridItem("Yasuo", R.drawable.yasuo),
            GridItem("Yone", R.drawable.yone),
            GridItem("Yorick", R.drawable.yorick),
            GridItem("Yuumi", R.drawable.yuumi),
            GridItem("Zac", R.drawable.zac),
            GridItem("Zed", R.drawable.zed),
            GridItem("Zeri", R.drawable.zeri),
            GridItem("Ziggs", R.drawable.ziggs),
            GridItem("Zilean", R.drawable.zilean),
            GridItem("Zoe", R.drawable.zoe),
            GridItem("Zyra", R.drawable.zyra)
        )

        adapter = GridAdapter(gridItems, requireContext())
        recyclerView.adapter = adapter
        recyclerView.layoutManager = GridLayoutManager(context, 4)

        // Set up search functionality
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                adapter.filter.filter(newText)
                return false
            }
        })

        return view
    }
}
