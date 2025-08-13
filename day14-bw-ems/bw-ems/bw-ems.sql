SELECT DISTINCT u.id,
                u.name,
                u.sex,
                u.tel,
                u.email,
                u.hiredate,
                u.root,
                u.`status`,
                (SELECT GROUP_CONCAT(role_name SEPARATOR ", ")
                 FROM bw_zzy_role
                 WHERE JSON_CONTAINS(u.role, CONVERT(id, CHAR))) AS roles,
                d.dept_name  AS dept
FROM bw_zzy_users u
         LEFT JOIN bw_zzy_role r ON JSON_CONTAINS(u.role, CONVERT(r.id, CHAR))
         LEFT JOIN bw_zzy_dept d ON u.dept_id = d.id
WHERE 1 = 1
  AND u.name = ?
  AND u.sex = ? #.... # 拼接查询条件
LIMIT ?,?


-- 查询总条数
SELECT COUNT(DISTINCT u.id)
FROM bw_zzy_users u
         LEFT JOIN bw_zzy_role r ON JSON_CONTAINS(u.role, CONVERT(r.id,CHAR))
         LEFT JOIN bw_zzy_dept d ON u.dept_id = d.id
WHERE 1=1
  AND u.name LIKE ?
  AND u.sex = ?
    #.... # 拼接查询条件