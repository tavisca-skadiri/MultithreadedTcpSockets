package models;

public class RequestHeaderData {
    private String resourceName;
    private String httpVersion;
    private String httpMethod;

    public RequestHeaderData(String header) {
        setHeaderData(header);
    }
    private void setHeaderData(String header) {
        if(header != null && !header.isEmpty()){
            String[] partsOfString = header.split(" ");
            this.httpMethod = partsOfString[0];
            this.resourceName = partsOfString[1];
            this.httpVersion = partsOfString[2];
        }
    }

    public String getResourceName() {
        return resourceName;
    }
    public String getHttpVersion() {
        return httpVersion;
    }
    public String getHttpMethod() {
        return httpMethod;
    }
    @Override
    public String toString() {
        return "models.RequestHeaderData{" +
                "resourceName='" + resourceName + '\'' +
                ", httpVersion='" + httpVersion + '\'' +
                ", httpMethod='" + httpMethod + '\'' +
                '}';
    }
}