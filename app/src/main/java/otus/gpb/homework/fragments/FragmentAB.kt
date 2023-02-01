package otus.gpb.homework.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class FragmentAB : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_a_b, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val color = arguments?.getInt("color") ?: 0

        view.findViewById<View>(R.id.fragmentAB).setBackgroundColor(color)
    }

    companion object {
        fun newInstance(color: Int) : FragmentAB {
            return FragmentAB().apply {
                arguments = Bundle().apply {
                    putInt("color", color)
                }
            }
        }
    }
}

