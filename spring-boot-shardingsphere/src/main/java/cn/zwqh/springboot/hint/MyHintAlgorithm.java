package cn.zwqh.springboot.hint;

import org.apache.shardingsphere.api.sharding.hint.HintShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.hint.HintShardingValue;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Hint分片算法需要用户实现org.apache.shardingsphere.api.sharding.hint.HintShardingAlgorithm接口。
 * ShardingSphere在进行Routing时，如果发现LogicTable的TableRule采用了 Hint的分片算法，将会从HintManager中获取分片值进行路由操作。
 */
@Component
public class MyHintAlgorithm implements HintShardingAlgorithm<Long> {
    @Override
    public Collection<String> doSharding(final Collection<String> availableTargetNames, final HintShardingValue<Long> shardingValue) {
        Collection<String> result = new ArrayList<>();
        for (String each : availableTargetNames) {
            System.out.println("---------------each"+each);
            for (Long value : shardingValue.getValues()) {
                if (each.endsWith(String.valueOf(value % 2))) {
                    result.add(each);
                }
            }
        }
        return result;
    }
}