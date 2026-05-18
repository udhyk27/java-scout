package com.ydh.scout.history;

public enum CollectStatus {
    SUCCESS,      // 수집 성공, 변경 있어서 저장
    NO_CHANGE,    // 수집 성공, 변경 없음
    FAILED        // 수집 실패
}
