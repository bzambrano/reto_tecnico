package co.com.siigo.model;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DataForRequest {
    private String url;
    private String path;
}
