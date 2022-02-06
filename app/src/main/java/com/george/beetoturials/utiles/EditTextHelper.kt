package com.george.beetoturials.utiles

import android.widget.EditText

enum class EditTextState { PASS, EMPTY, LOGIC_NOT_COMPATIBLE }

data class EditTextModel(
    val et: EditText,
    val messageEmpty: String,
    val messageLogic: String,
    val logic: ((EditText) -> Boolean)? = null,
)

object EditTextHelper {


    ////////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////// EDIT TEXT HELPERS ////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////
    fun EditText.getTxt() = text.toString()

    fun EditText.isEmpty() = getTxt().isEmpty()

    fun EditText.isValid(logic: (EditText) -> Boolean): EditTextState {
        return when {
            this.isEmpty() -> EditTextState.EMPTY
            logic(this) -> EditTextState.LOGIC_NOT_COMPATIBLE
            else -> EditTextState.PASS
        }
    }

    fun isFromValid(editTexts: List<EditTextModel>): String {

        val messages = mutableListOf<String>()

        editTexts.forEach { model ->

            val valid = model.et.isValid { et ->
                model.logic?.let { !it(et) } ?: true
            }

            when (valid) {
                EditTextState.LOGIC_NOT_COMPATIBLE -> messages.add(model.messageLogic)
                EditTextState.EMPTY -> messages.add(model.messageEmpty)
                EditTextState.PASS -> {}
            }

        }

        return messages.joinToString(", ")
    }


    // show snackBar with alert message if any inputs is empty
    fun EditText.showEmptyEditText(msg: String) = if (text.isEmpty()) {
        error = msg
        false
    } else true

}