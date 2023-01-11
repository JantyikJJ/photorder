package nyomorultak.photorder.generic;

public class PhotorderResponse<T> {
    public T data;
    public boolean error;


    public PhotorderResponse(T data) {
        this.data = data;
        this.error = false;
    }
    public PhotorderResponse() {
        this.error = true;
    }
}