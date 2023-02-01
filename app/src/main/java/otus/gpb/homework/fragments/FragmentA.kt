package otus.gpb.homework.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button

class FragmentA : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_a, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val generatedColor = ColorGenerator.generateColor()

        view.findViewById<Button>(R.id.button_open_aa).setOnClickListener{
            childFragmentManager.beginTransaction()
                .replace(R.id.fragment_aa_container, FragmentAA.newInstance(generatedColor))
                .addToBackStack(null)
                .commit()
            it.visibility = View.GONE
        }
    }

}
