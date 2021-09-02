public class Field {

    private String field;
    private boolean isFulled;

    public Field(String field){
        this.field = field;
        isFulled = false;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        if(!isFulled) {
            this.field = field;
            isFulled = true;
        }
    }

}
