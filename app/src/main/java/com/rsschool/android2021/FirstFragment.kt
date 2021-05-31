package com.rsschool.android2021

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment

class FirstFragment : Fragment() {

    private var generateButton: Button? = null
    private var previousResult: TextView? = null
    private var minEditText: EditText? = null
    private var maxEditText: EditText? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        previousResult = view.findViewById(R.id.previous_result)
        generateButton = view.findViewById(R.id.generate)
        generateButton?.isEnabled=false
        minEditText = view.findViewById(R.id.min_value)
        maxEditText = view.findViewById(R.id.max_value)

        val result = arguments?.getInt(PREVIOUS_RESULT_KEY)
        previousResult?.text = "Previous result: ${result.toString()}"

        minEditText?.addTextChangedListener{
            val min = minEditText?.text.toString().toIntOrNull()
            val max = maxEditText?.text.toString().toIntOrNull()

            if (min == null || max == null){
                Toast.makeText(getActivity(), "max or min NULL", Toast.LENGTH_SHORT).show()
                generateButton?.isEnabled=false
            }
            else{
                if(min > Int.MAX_VALUE)Toast.makeText(getActivity(), " min is BIG", Toast.LENGTH_SHORT).show()
                if(max > Int.MAX_VALUE)Toast.makeText(getActivity(), " min is BIG", Toast.LENGTH_SHORT).show()
                if (min>max){
                    generateButton?.isEnabled=false
                    Toast.makeText(getActivity(), "min > max", Toast.LENGTH_SHORT).show()
                }
                if(min>0 && max>0 && min<max){
                    Toast.makeText(getActivity(), "max and min OK", Toast.LENGTH_SHORT).show()
                    generateButton?.isEnabled=true
                }
            }

        }
        maxEditText?.addTextChangedListener{
            val min = minEditText?.text.toString().toIntOrNull()
            val max = maxEditText?.text.toString().toIntOrNull()
            Int.MAX_VALUE
            if (min == null || max == null){
                Toast.makeText(getActivity(), "max or min NULL", Toast.LENGTH_SHORT).show()
                generateButton?.isEnabled=false
            }
            else{
                if(min > Int.MAX_VALUE)Toast.makeText(getActivity(), " min is BIG", Toast.LENGTH_SHORT).show()
                if(max > Int.MAX_VALUE)Toast.makeText(getActivity(), " min is BIG", Toast.LENGTH_SHORT).show()
                if (min>max){
                    generateButton?.isEnabled=false
                    Toast.makeText(getActivity(), "min > max", Toast.LENGTH_SHORT).show()
                }
                if(min>0 && max>0 && min<max){
                    Toast.makeText(getActivity(), "max and min OK", Toast.LENGTH_SHORT).show()
                    generateButton?.isEnabled=true
                }
            }
        }

        generateButton?.setOnClickListener {
            val min = minEditText?.text.toString().toInt()
            val max = maxEditText?.text.toString().toInt()
            if (min <= max) {
                (activity as SwitchFragment).switchToSecondFragment(min, max)
            }
        }
    }

    companion object {

        @JvmStatic
        fun newInstance(previousResult: Int): FirstFragment {
            val fragment = FirstFragment()
            val args = Bundle()
            args.putInt(PREVIOUS_RESULT_KEY, previousResult)
            fragment.arguments = args
            return fragment
        }

        private const val PREVIOUS_RESULT_KEY = "PREVIOUS_RESULT"
    }
}