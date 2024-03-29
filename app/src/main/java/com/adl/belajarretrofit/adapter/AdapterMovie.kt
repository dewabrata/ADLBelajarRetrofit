package com.adl.belajarretrofit.adapter

import android.content.Context
import android.graphics.Typeface
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseExpandableListAdapter
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.adl.belajarretrofit.R
import com.adl.belajarretrofit.model.SearchItem

import java.util.*

/**
 * Created by Panacea-Soft on 8/26/18.
 * Contact Email : teamps.is.cool@gmail.com
 */


@Suppress("NAME_SHADOWING")
class FeatureListEducationCategoryList1Adapter(private val _context: Context, private val _listDataHeader: List<String>,
                                               private val _listDataChild: HashMap<String, List<SearchItem>>) : BaseExpandableListAdapter() {

    override fun getChild(groupPosition: Int, childPosititon: Int): Any {
        return this._listDataChild[this._listDataHeader[groupPosition]]!![childPosititon]
    }

    override fun getChildId(groupPosition: Int, childPosition: Int): Long {
        return childPosition.toLong()
    }

    override fun getChildView(groupPosition: Int, childPosition: Int,
                              isLastChild: Boolean, convertView: View?, parent: ViewGroup): View {
        var convertView = convertView

        val childText = getChild(groupPosition, childPosition) as SearchItem

        if (convertView == null) {
            val infalInflater = this._context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            convertView = infalInflater.inflate(R.layout.feature_list_education_category_list_1_item, parent, false)
        }

        val txtListChild = convertView?.findViewById<TextView>(R.id.lblListItem)

        txtListChild?.text = childText.title
        return convertView!!
    }

    override fun getChildrenCount(groupPosition: Int): Int {
        return this._listDataChild[this._listDataHeader[groupPosition]]!!
                .size
    }

    override fun getGroup(groupPosition: Int): Any {
        return this._listDataHeader[groupPosition]
    }

    override fun getGroupCount(): Int {
        return this._listDataHeader.size
    }

    override fun getGroupId(groupPosition: Int): Long {
        return groupPosition.toLong()
    }

    override fun getGroupView(groupPosition: Int, isExpanded: Boolean,
                              view: View?, parent: ViewGroup): View {
        var convertView = view
        val headerTitle = getGroup(groupPosition) as String
        if (convertView == null) {
            val infalInflater = this._context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            convertView = infalInflater.inflate(R.layout.feature_list_education_category_list_1_group, parent, false)
        }

        val lblListHeader = convertView?.findViewById<TextView>(R.id.lblListHeader)
        lblListHeader?.setTypeface(null, Typeface.BOLD)
        lblListHeader?.text = headerTitle

        val groupIndicatorImageView = convertView?.findViewById<ImageView>(R.id.groupIndicatorImageView)

        if (isExpanded) {
            groupIndicatorImageView?.setImageDrawable(ContextCompat.getDrawable(parent.context!!,R.drawable.ic_arrow_drop_up_black_24dp))
        } else {
            groupIndicatorImageView?.setImageDrawable(ContextCompat.getDrawable(parent.context!!,R.drawable.ic_arrow_drop_down_black_24dp))

        }

        return convertView!!
    }

    override fun hasStableIds(): Boolean {
        return false
    }

    override fun isChildSelectable(groupPosition: Int, childPosition: Int): Boolean {
        return true
    }
}