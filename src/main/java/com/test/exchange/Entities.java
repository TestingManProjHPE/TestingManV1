package com.test.exchange;

import java.util.List;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

@Root(name = "Entities")
public class Entities {

	public String getTotalResults() {
		return totalResults;
	}

	public void setTotalResults(String totalResults) {
		this.totalResults = totalResults;
	}

	@Attribute(name = "TotalResults")
	private String totalResults;

	@ElementList(inline = true)
	private List<Entity> list;
	
	@Element(name = "singleElementCollection", required = false)
	private String singleElementCollection;

	public List<Entity> getList() {
		return list;
	}

	public void setList(List<Entity> list) {
		this.list = list;
	}

}

@Root(name = "Entity")
class Entity {
	public String getType() {
		return Type;
	}

	public void setType(String type) {
		Type = type;
	}

	@Attribute(name = "Type")
	private String Type;

	@ElementList(inline = true)
	private List<Fields> list;

	public List<Fields> getList() {
		return list;
	}

	public void setList(List<Fields> list) {
		this.list = list;
	}

	@Element(name = "ChildrenCount")
	private ChildrenCount childrenCount;

	@Element(name = "RelatedEntities", required = false)
	private String relatedEntities;

	public ChildrenCount getChildrenCount() {
		return childrenCount;
	}

	public void setChildrenCount(ChildrenCount childrenCount) {
		this.childrenCount = childrenCount;
	}

}

@Root
class ChildrenCount {
	@Element
	private String Value;

	public String getValue() {
		return Value;
	}

	public void setValue(String value) {
		Value = value;
	}

}

@Root(name = "Fields")
class Fields {
	public List<Field> getField() {
		return field;
	}

	public void setField(List<Field> field) {
		this.field = field;
	}

	@ElementList(inline = true)
	private List<Field> field;

}

@Root(name = "Field")
class Field {
	public String getValue() {
		return Value;
	}

	public void setValue(String value) {
		Value = value;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Element(required = false)
	private String Value;

	@Attribute(name = "Name")
	private String name;

}
