package otus.gpb.homework.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment

class FragmentA: Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_a, container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val fragmentAAColor = ColorGenerator.generateColor()

        val fragmentAA = FragmentAA.createNewInstance(fragmentAAColor)

        view.findViewById<Button>(R.id.button_to_AA)?.setOnClickListener {
            childFragmentManager.beginTransaction()
                .replace(R.id.childs_container, fragmentAA)
                .addToBackStack(null)
                .commit()
            it.visibility = View.GONE
        }

        requireActivity().onBackPressedDispatcher.addCallback(
            object : OnBackPressedCallback(true) {
                override fun handleOnBackPressed() {
                    if (childFragmentManager.backStackEntryCount > 0) {
                        childFragmentManager.popBackStack()
                    } else {
                        requireActivity().finish()
                    }
                }
            }
        )
    }



}