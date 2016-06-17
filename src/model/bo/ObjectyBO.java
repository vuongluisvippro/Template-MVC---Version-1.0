package model.bo;

import java.util.ArrayList;

import model.bean.Objecty;
import model.dao.ObjectyDAO;

@SuppressWarnings("all")
public class ObjectyBO {

	public ArrayList<Objecty> getList() {
		return new ObjectyDAO().getList();
	}
	
}
