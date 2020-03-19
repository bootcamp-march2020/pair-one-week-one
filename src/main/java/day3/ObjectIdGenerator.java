package day3;

class  ObjectIdGenerator{

    private IGuid iGuid;

    public ObjectIdGenerator(IGuid iGuid){
        this.iGuid = iGuid;
    }

    public String generateId() {
        return iGuid.getUniqueId();
    }
}