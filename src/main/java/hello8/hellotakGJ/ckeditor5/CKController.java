/*
package hello8.hellotakGJ.ckeditor5;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@Api(value = "이미지 저장 관련 API", tags = {"CKController"}, description = "이미지 저장 컨트롤러")
@RestController
@Slf4j
@RequestMapping("/api/image")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class CKController {
    private final FileUploadService fileUploadService;

    @PostMapping("/upload")
    @ApiOperation(value = "이미지 url 생성 후 반환", notes = "CK5 에디터에 올라온 이미지의 url을 생성후 반환한다.")
    @ApiResponses({
            @ApiResponse(code = 201, message = "성공"),
            @ApiResponse(code = 404, message = "등록 실패"),
            @ApiResponse(code = 500, message = "서버 오류")
    })
    public ResponseEntity<FileResponse> fileUploadFromCKEditor(HttpServletResponse response,
                                                               @RequestPart(value = "image", required = false) MultipartFile image) throws Exception {

        */
/**
         * @Method Name : fileUploadFromCKEditor
         * @작성자 :
         * @Method 설명 : 이미지를 받아 s3에 저장 후 url을 json 형태로 반환.
         *//*

        return new ResponseEntity<>(FileResponse.builder().
                uploaded(true).
                url(fileUploadService.upload(image)).
                build(), HttpStatus.OK);
    }
}
*/
