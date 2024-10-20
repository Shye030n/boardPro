package orgsh.boardpro.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Arrays;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageRequestDTO {

    @Builder.Default
    @Min(value = 1)
    @Positive
    private int page=1; //클라이언트 화면에서 현재 페이지

    @Builder.Default
    @Min(value = 3)
    @Max(value = 100)
    @Positive
    private int size=3; // 한 페이지당 보여줄 항목 개수

    private String link;

    private String[] types;
    private String keyword;
    private boolean finished;
    private LocalDate from;
    private LocalDate to;


    public int getSkip(){
        // 페이지 넘기기 계산
        return(page-1)*this.size;
        // 1페이지: 데이터의 시작점은 0 (항목 1부터 시작)
        // 2페이지: 데이터의 시작점은 10 (항목 11부터 시작)
        // 3페이지: 데이터의 시작점은 20 (항목 21부터 시작)
    }
    //    public String getLink() {
//            StringBuilder builder = new StringBuilder();
//            builder.append("page=" + this.page);
//            builder.append("&size=" + this.size);
//            return builder.toString();
//    }
    public String getLink() {
        StringBuilder builder = new StringBuilder();
        builder.append("page=" + this.page);
        builder.append("&size=" + this.size);
        if(finished){
            builder.append("&finished=on");
        }
        if(types!=null && types.length>0){
            for(int i=0; i<types.length; i++){
                builder.append("&types=" + types[i]);
            }
        }
        if(keyword!=null){
            builder.append("&keyword=" + keyword);
        }
        if(from!=null){
            builder.append("&from=" + from.toString());
        }
        if(to!=null){
            builder.append("&to=" + to.toString());
        }
        return builder.toString();
    }
    public boolean checkType(String type) {
        if (types == null || types.length == 0) {
            return false;
        }
        return Arrays.stream(types).anyMatch(type::equals);
    }
}


