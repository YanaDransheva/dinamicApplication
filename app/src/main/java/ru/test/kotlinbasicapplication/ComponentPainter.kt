package ru.test.kotlinbasicapplication

import android.text.InputType
import android.text.format.DateFormat
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.google.android.material.textfield.TextInputEditText
import java.util.*


// Класс который по входящему набору списка атрибутов, строит динамическую форму
class ComponentPainter (val activity: MainActivity,
                        val rootContainer: LinearLayout,
                        val attributeList: AttributeList) {
    // создаем текстовый редактор
    private val simpleLayoutParametrs =  LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT) ;


    // Создать атрибут
    private fun createEditor(attribute: Attribute){
        //        функция числового отображения
        fun integerView(Layout: LinearLayout){
            val textInputEditText = TextInputEditText(activity)
            textInputEditText.width = 600
            Layout.addView(textInputEditText)



        }// конец integerView()



        //создаем горизонтальную разметку
        val horizontalLayout = LinearLayout(activity)
        horizontalLayout.orientation = LinearLayout.HORIZONTAL
        // Создаем текст вью. Просмотр текста
        val textView = TextView(activity)
        textView.setText(attribute.name)
        textView.setRawInputType(InputType.TYPE_CLASS_DATETIME)

        textView.width = 300
        horizontalLayout.addView(textView)


        //        функция булевая отображения
        fun boleanView(){
            val switch = Switch(activity)
            switch.width = 600
            horizontalLayout.addView(switch)


        } // конец boleanView()

        //        функция дата отображения
        fun dateView(){
           // val date = DatePicker(activity)
//            date.width = 600
//            date.setRawInputType(InputType.TYPE_DATETIME_VARIATION_DATE)
        //    horizontalLayout.addView(date)

        } // конец dateView()

        //        функция строкового отображения
        fun stringView(){
            val textView = TextView(activity)

            textView.width = 600
            textView.setText("123")
            horizontalLayout.addView(textView)
            textView.setOnClickListener(object : View.OnClickListener {
                override fun onClick(v: View?) {
                    Toast.makeText(activity, "ffffff", Toast.LENGTH_SHORT).show()
                   // toast("View clicked!")
                }
            })


          
        }// конец stringView()

        if (attribute.type == AttributeType.INTEGER) {
            integerView(horizontalLayout)
        }
        if (attribute.type == AttributeType.BOOLEAN) {
            boleanView()
        }
        if (attribute.type == AttributeType.DATE) {
            dateView()
        }
        if (attribute.type == AttributeType.STRING) {
            stringView()
        }


//         создаем редактор текста
//        val button = Button(activity)
//        button.width = 600
//        horizontalLayout.addView(button)
//
//        val button2 = Button(activity)
//        button2.width = 80
//        horizontalLayout.addView(button2)

        rootContainer.addView(horizontalLayout)
    }

    // Нарисовать компоненты на Активити
    fun drawAttributes() {
        // Устанавливаем параметры
        val params = LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT)
        // Перебираем атрибуты и добавляем элементы в список
        for (i in 0..attributeList.count()-1) {
            val attribute = attributeList.get(i)
            createEditor(attribute)
        }
    }

}