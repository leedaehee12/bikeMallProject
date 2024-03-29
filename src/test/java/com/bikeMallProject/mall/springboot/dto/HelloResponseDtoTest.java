package com.bikeMallProject.mall.springboot.dto;

import com.bikeMallProject.mall.springboot.web.dto.HelloResponseDto;
import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

public class HelloResponseDtoTest {
    @Test
    public void 롬복_기능_테스트(){

        //given
        String name = "Test";
        int amount = 1000;
        //when
        HelloResponseDto dto = new HelloResponseDto(name, amount);

        //then
        assertThat(dto.getName()).isEqualTo(name);
        assertThat(dto.getAmount()).isEqualTo(amount);

    }

}
