package org.simpleframework.aop.aspect;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author yangxin
 * 2022/5/25 22:24
 */
@AllArgsConstructor
@Getter
public class AspectInfo {

    private int orderIndex;

    private DefaultAspect aspectObject;
}
