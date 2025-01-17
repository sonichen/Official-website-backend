package com.dl.officialsite.redpacket;


import com.dl.officialsite.common.converter.StringListConverter;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.checkerframework.common.value.qual.StringVal;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
@Entity
public class RedPacket {
    @NotNull
    private String  name;
    @NotNull
    @Id
    @Column(length = 66)
    private String id;
    @NotNull
    private String creator;
    @NotNull
    @Convert(converter = StringListConverter.class)
    private List<String> address;
    @NotNull
    private Long expireTime;
    @CreatedDate
    @Column(updatable = false)
    private Long createTime;
    @NotNull
    private String chainId;
    private  int statue;
    private Long amount;
    //contractAddress???
}
