package NHCBDP.webModule.Domain;

/**
 * @author wbliu
 * @create 2017-09-05 16:43
 **/


public class TableFieldBean {
String  field;
String  type;
String  isNull;
String key;
String default0;
String extra;


    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getIsNull() {
        return isNull;
    }

    public void setIsNull(String isNull) {
        this.isNull = isNull;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getDefault0() {
        return default0;
    }

    public void setDefault0(String default0) {
        this.default0 = default0;
    }

    public String getExtra() {
        return extra;
    }

    public void setExtra(String extra) {
        this.extra = extra;
    }



    @Override
    public String toString() {
        return "TableStructBean{" +
                "field='" + field + '\'' +
                ", type='" + type + '\'' +
                ", isNull='" + isNull + '\'' +
                ", key='" + key + '\'' +
                ", default0='" + default0 + '\'' +
                ", extra='" + extra + '\'' +
                '}';
    }
}
